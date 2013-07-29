
package de.m0ep.socc.core;

import org.ontoware.rdf2go.model.Model;

import com.google.common.base.Preconditions;

import de.m0ep.socc.core.acl.IAccessControl;

public class SoccContext implements ISoccContext {

    private Model model;
    private IAccessControl accessControl;

    public SoccContext(final Model model) {
        this.model = Preconditions.checkNotNull(
                model,
                "Required parameter model must be specified.");
        Preconditions.checkArgument(
                model.isOpen(),
                "Required paramater model is not open");

        // TODO: finish initialization
    }

    @Override
    public Model getModel() {
        return model;
    }

    @Override
    public IAccessControl getAccessControl() {
        return accessControl;
    }
}