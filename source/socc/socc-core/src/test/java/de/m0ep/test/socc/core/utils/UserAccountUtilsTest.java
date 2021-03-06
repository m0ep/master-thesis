/*
 * The MIT License (MIT) Copyright © 2013 Florian Müller
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.m0ep.test.socc.core.utils;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ontoware.rdf2go.RDF2Go;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.node.URI;
import org.ontoware.rdf2go.util.Builder;
import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.services.Service;

import com.xmlns.foaf.Person;

import de.m0ep.socc.core.exceptions.NotFoundException;
import de.m0ep.socc.core.utils.UserAccountUtils;

public class UserAccountUtilsTest {

	private static final URI URI_SERVICE_A = Builder.createURI( "http://www.example.com/serviceA" );
	private static final URI URI_SERVICE_B = Builder.createURI( "http://www.example.com/serviceB" );

	private Model model;

	private Person person1;
	private Person person2;
	private Person person3;

	private UserAccount person1Acc1;
	private UserAccount person1Acc2;

	private UserAccount person2Acc1;

	private Service service;

	@Before
	public void setUp() throws Exception {
		model = RDF2Go.getModelFactory().createModel();
		model.open();

		service = new Service( model, true );

		person1 = new Person( model, true );
		person1.setName( "John Doe" );
		person1.setFirstName( "John" );
		person1.setLastName( "Doe" );

		person1Acc1 = new UserAccount( model, true );
		person1Acc1.setAccountName( "johndoe" );
		person1Acc1.setAccountServiceHomepage( URI_SERVICE_A );
		person1Acc1.setAccountOf( person1 );
		service.addServiceOf( person1Acc1 );

		person1Acc2 = new UserAccount( model, true );
		person1Acc2.setAccountName( "johndoe85" );
		person1Acc2.setAccountServiceHomepage( URI_SERVICE_B );
		person1Acc2.setAccountOf( person1 );
		service.addServiceOf( person1Acc2 );

		person1.setAccount( person1Acc1 );
		person1.setAccount( person1Acc2 );

		person2 = new Person( model, true );
		person2.setName( "Jenny Doe" );
		person2.setFirstName( "Jenny" );
		person2.setLastName( "Doe" );

		person2Acc1 = new UserAccount( model, true );
		person2Acc1.setAccountName( "jennydoe" );
		person2Acc1.setAccountServiceHomepage( URI_SERVICE_B );
		de.m0ep.socc.config.UserAccount.setMappedTo( model, person2Acc1, person1Acc1 );

		person2.setAccount( person2Acc1 );

		person3 = new Person( model, true );
		person3.setName( "James Doe" );
		person3.setFirstName( "James" );
		person3.setLastName( "Doe" );
	}

	@After
	public void tearDown() throws Exception {
		model.close();
		model = null;
	}

	@Test
	public void testListUserAccounts() {
		List<UserAccount> actual1 = UserAccountUtils.listUserAccounts( model, person1 );
		Assert.assertNotNull( "Result shouldn't be null", actual1 );
		Assert.assertEquals( "Expected 2 results, was " + actual1.size(), 2, actual1.size() );

		List<UserAccount> actual2 = UserAccountUtils.listUserAccounts( model, person2 );
		Assert.assertNotNull( "Result shouldn't be null", actual2 );
		Assert.assertEquals( "Expected 1 results, was " + actual2.size(), 1, actual2.size() );

		List<UserAccount> actual3 = UserAccountUtils.listUserAccounts( model, person3 );
		Assert.assertNotNull( "Result shouldn't be null", actual3 );
		Assert.assertEquals( "Expected 0 results, was " + actual3.size(), 0, actual3.size() );
	}

	@Test
	public void testFindUserAccount() throws NotFoundException {
		UserAccount actual = UserAccountUtils.findUserAccount(
		        model,
		        person1Acc1.getAccountName(),
		        person1Acc1.getAccountServiceHomepage().asURI() );
		Assert.assertEquals( person1Acc1, actual );

		actual = UserAccountUtils.findUserAccount(
		        model,
		        person2Acc1.getAccountName(),
		        person2Acc1.getAccountServiceHomepage().asURI() );
		Assert.assertEquals( person2Acc1, actual );
	}

	@Test( expected = NotFoundException.class )
	public void testFindUserAccountNotFound() throws NotFoundException {
		UserAccountUtils.findUserAccount(
		        model,
		        "James May",
		        Builder.createURI( "http://www.example.com/serviceC" ) );
	}

	@Test
	public void findUserAccountOfService() throws NotFoundException {
		UserAccount actual = UserAccountUtils.findUserAccountOfService(
		        model,
		        person1,
		        URI_SERVICE_A );
		Assert.assertEquals( person1Acc1, actual );

		actual = UserAccountUtils.findUserAccountOfService( model, person1Acc1, service );
		Assert.assertEquals( person1Acc1, actual );

		actual = UserAccountUtils.findUserAccountOfService( model, person2Acc1, service );
		Assert.assertEquals( person1Acc1, actual );
	}

	@Test( expected = NotFoundException.class )
	public void findUserAccountOfServiceNotFound() throws NotFoundException {
		UserAccountUtils.findUserAccountOfService( model, person2, URI_SERVICE_A );
	}

	@Test
	public void testFindPerson() throws NotFoundException {
		Person actual = UserAccountUtils.findPerson( model, person1Acc1 );
		Assert.assertEquals( person1, actual );

		actual = UserAccountUtils.findPerson( model, person1Acc2 );
		Assert.assertEquals( person1, actual );
	}

	@Test( expected = NotFoundException.class )
	public void testFindPersonNotFound() throws NotFoundException {
		UserAccountUtils.findPerson( model, new UserAccount( model, false ) );
	}
}
