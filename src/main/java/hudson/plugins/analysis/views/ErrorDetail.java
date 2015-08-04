package hudson.plugins.analysis.views;

import java.util.Collection;

import javax.annotation.CheckForNull;

import hudson.model.AbstractBuild;
import hudson.model.Run;
import hudson.model.ModelObject;

import hudson.plugins.analysis.Messages;

/**
 * Result object to visualize the errors during execution of the plug-in.
 *
 * @author Ulli Hafner
 */
public class ErrorDetail implements ModelObject  {
    /** Current build as owner of this action. */
    private final Run<?, ?> owner;
    /** All errors of the project. */
    private final Collection<String> errors;

    /**
     * Creates a new instance of <code>ErrorDetail</code>.
     *
     * @param owner
     *            current build as owner of this action.
     * @param errors
     *            all modules of the project
     */
    public ErrorDetail(final Run<?, ?> owner, final Collection<String> errors) {
        this.owner = owner;
        this.errors = errors;
    }

    /**
     * Returns the build as owner of this action.
     *
     * @return the owner
     * @deprecated use {@link #getBuild()} instead
     */
    @CheckForNull
    @Deprecated
    public final AbstractBuild<?, ?> getOwner() {
        return owner instanceof AbstractBuild ? (AbstractBuild) owner : null;
    }

    /**
     * Returns the run as owner of this action.
     * @since 1.73
     */
    public Run<?, ?> getBuild() {
        return owner;
    }

    @Override
    public String getDisplayName() {
        return Messages.Errors();
    }

    /**
     * Returns the errors in the project.
     *
     * @return the errors in the project
     */
    public Collection<String> getErrors() {
        return errors;
    }

    /**
     * Creates a new instance of <code>ErrorDetail</code>.
     *
     * @param owner
     *            current build as owner of this action.
     * @param errors
     *            all modules of the project
     * @deprecated use {@link #ErrorDetail(Run, Collection)} instead
     */
    @Deprecated
    public ErrorDetail(final AbstractBuild<?, ?> owner, final Collection<String> errors) {
        this.owner = owner;
        this.errors = errors;
    }
}

