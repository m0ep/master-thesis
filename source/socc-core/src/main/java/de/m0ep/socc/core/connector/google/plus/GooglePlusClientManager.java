
package de.m0ep.socc.core.connector.google.plus;

import org.rdfs.sioc.UserAccount;
import org.rdfs.sioc.services.Service;

import de.m0ep.socc.core.connector.AbstractServiceClientManager;

public class GooglePlusClientManager extends AbstractServiceClientManager {

    public GooglePlusClientManager(Service service) {
        super(service);
    }

    public GooglePlusClientManager(Service service, UserAccount defaultUserAccount)
            throws Exception {
        super(service, defaultUserAccount);
    }

    @Override
    public Object createClientFromAccount(UserAccount userAccount) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}