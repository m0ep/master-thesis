package de.m0ep.socc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.ServiceLoader;

import org.ontoware.aifbcommons.collection.ClosableIterator;
import org.ontoware.rdf2go.RDF2Go;
import org.ontoware.rdf2go.exception.ModelRuntimeException;
import org.ontoware.rdf2go.model.Model;
import org.ontoware.rdf2go.model.Syntax;
import org.ontoware.rdf2go.model.node.Node;
import org.rdfs.sioc.Container;
import org.rdfs.sioc.Forum;
import org.rdfs.sioc.Item;
import org.rdfs.sioc.Post;
import org.rdfs.sioc.SIOCThing;
import org.rdfs.sioc.Thread;
import org.rdfs.sioc.UserAccount;

import de.m0ep.socc.connectors.Connector;
import de.m0ep.socc.connectors.ConnectorFactory;
import de.m0ep.socc.connectors.facebook.FacebookConnector;
import de.m0ep.socc.connectors.moodle.MoodleConnector;

public class SOCCTest {

    // private static Connector connector;
    private static final boolean WRITE_DUMP = false;
    private static final boolean WRITE_OUTPUT = true;

    /**
     * @param args
     */
    public static void main(String[] args) {
	Model model = RDF2Go.getModelFactory().createModel();
	model.open();

	Properties config = new Properties();
	config.put(
		FacebookConnector.CONFIG_ACCESS_TOKEN,
		"AAADGb3p3g9wBAEBIgudxWemgEWEjsMZAfBO6q8ZBs8SvkHu9eTC5yfzCWrPkwNZBSOwGqmaQF7Axpj7ZBsH27CjFt6alhbZBSOq74wurtVAZDZD");
	config.put(FacebookConnector.CONFIG_CLIENT_ID, "218182098322396");
	config.put(FacebookConnector.CONFIG_CLIENT_SECRET,
		"7b80b9d7265c719e1d9efe112e4dbada");
	config.put(MoodleConnector.CONFIG_MOODLE_URL,
		"http://localhost/florian/moodle24/");
	config.put(MoodleConnector.CONFIG_USERNAME, "admin");
	config.put(MoodleConnector.CONFIG_PASSWORD, "admin");

	Connector[] connectors = {
	// new FacebookConnector("facebook", model, config),
	// new MoodleConnector("Moodle", model, config)
	};

	ServiceLoader<ConnectorFactory> factoryLoader = ServiceLoader
		.load(ConnectorFactory.class);

	Iterator<ConnectorFactory> iter = factoryLoader.iterator();
	while (iter.hasNext()) {
	    ConnectorFactory factory = (ConnectorFactory) iter.next();
	    System.out.println(factory.getConnectorName());

	}

	for (Connector connector : connectors) {
	    printConnector(connector);
	}

	System.out.println();
	System.out.println();
	System.out.println("model dump===============================");
	System.out.println();
	model.dump();

	if (WRITE_DUMP) {
	    String filename = "fb_mdl-" + new Date().getTime() + ".rdf";
	    System.out.println("Write model to " + filename);
	    try {
		model.writeTo(
			new FileOutputStream(filename), Syntax.RdfXml);
	    } catch (ModelRuntimeException e) {
		e.printStackTrace();
	    } catch (FileNotFoundException e) {
		e.printStackTrace();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    private static void printConnector(Connector connector) {
	System.out.println();
	System.out.println(connector.getURL());
	System.out.println("=====================================");
	System.out.println("=====================================");

	UserAccount user = connector.getUser();
	printUser(user, 0);

	Iterator<Forum> forums = connector.getForums();

	while (forums.hasNext()) {
	    Forum forum = (Forum) forums.next();

	    printWithIndent("Forum===============", 0);
	    printWithIndent("uri:        " + forum, 0);
	    printWithIndent("id:         " + forum.getAllId_as().firstValue(),
		    0);
	    printWithIndent(
		    "name:       " + forum.getAllName_as().firstValue(), 0);
	    printWithIndent("desc:       "
		    + forum.getAllDescription_as().firstValue(), 0);
	    printWithIndent("mod:        "
		    + forum.getAllModified_as().firstValue(), 0);
	    printWithIndent(
		    "host:       " + forum.getAllHost_as().firstValue(), 0);
	    printWithIndent("canpublish: " + connector.canPublishOn(forum), 0);

	    if (connector.hasPosts(forum)) {
		listPosts(connector, forum, 1);
	    }

	    Iterator<Thread> threads = connector.getThreads(forum);

	    while (threads.hasNext()) {
		Thread thread = (Thread) threads.next();

		printWithIndent("Thread..............", 1);
		printWithIndent("uri:        " + thread, 1);
		printWithIndent("id:         "
			+ thread.getAllId_as().firstValue(), 1);
		printWithIndent("name:       "
			+ thread.getAllName_as().firstValue(), 1);
		printWithIndent("mod:        "
			+ thread.getAllModified_as().firstValue(), 1);
		printWithIndent("parent:     "
			+ thread.getAllParent_as().firstValue(), 1);
		printWithIndent("creator:    "
			+ thread.getAllCreator_as().firstValue(), 1);
		printWithIndent(
			"canpublish: " + connector.canPublishOn(thread), 1);

		if (connector.hasPosts(thread)) {
		    listPosts(connector, thread, 2);
		}
	    }
	    printWithIndent("====================", 0);
	    printWithIndent("", 0);

	    // break;
	}

    }

    private static void listPosts(Connector connector, Container container,
	    int indent) {
	Iterator<Post> posts = connector.getPosts(container);

	int ctr = 0;
	while (posts.hasNext()) {
	    Post post = (Post) posts.next();
	    printPost(connector, post, indent);

	    if (5 == ctr++)
		break;
	}
    }

    static void printUser(UserAccount user, int indent) {
	printWithIndent("uri:      " + user, indent);
	printWithIndent(
		"id:       "
			+ SIOCThing.getAllId_as(user.getModel(), user)
				.firstValue(), indent);
	printWithIndent("name:     " + user.getAllName_as().firstValue(),
		indent);
	printWithIndent(
		"username: " + user.getAllAccountname_as().firstValue(), indent);
	printWithIndent("profile:  "
		+ user.getAllAccountservicehomepage_as().firstValue(), indent);
    }

    static void printPost(Connector connector, Item post, int indent) {
	printWithIndent("Post-----------------", indent);
	printWithIndent("uri:       " + post, indent);
	printWithIndent("id:        " + post.getAllId_as().firstValue(), indent);
	printWithIndent("content:   " + post.getAllContent_as().firstValue(),
		indent);
	printWithIndent("created:   " + post.getAllCreated_as().firstValue(),
		indent);
	printWithIndent("mod:       " + post.getAllModified_as().firstValue(),
		indent);
	printWithIndent("container: " + post.getAllContainer_as().firstValue(),
		indent);
	if (post.hasReplyof())
	    printWithIndent("parent:    "
		    + post.getAllReplyof_as().firstValue(), indent);
	printWithIndent(
		"canreply:  "
			+ connector.canReplyOn(Post.getInstance(
				post.getModel(), post.getResource())), indent);

	if (post.hasCreator()) {
	    printWithIndent("Post.From----------------", indent);
	    printUser(post.getAllCreator_as().firstValue(), indent + 1);
	}

	if (post.hasAttachment()) {
	    printWithIndent("Post.Attachments---------", indent);

	    ClosableIterator<Node> attachments = post.getAllAttachment_asNode();
	    while (attachments.hasNext()) {
		Node node = (Node) attachments.next();
		printWithIndent(node.toString(), indent);

	    }
	    attachments.close();
	}

	if (post.hasReply()) {
	    printWithIndent("Post.Replies-------------", indent);

	    ClosableIterator<Item> replies = post.getAllReply();

	    while (replies.hasNext()) {
		Item item = (Item) replies.next();
		printPost(connector, item, indent + 1);
	    }
	    replies.close();
	}
    }

    static void printWithIndent(String text, int val) {
	String indent = "";
	while (0 < val) {
	    indent += "  ";
	    val--;
	}

	if (WRITE_OUTPUT)
	    System.out.println(indent + text);
    }
}
