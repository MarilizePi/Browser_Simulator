package stacks;

import java.util.EmptyStackException;

/**
 * Navigator class provides the navigation feature of class BrowserNavigation.
 * It keeps a stack of each of the "back" and "forward" links.
 *
 * @author Pires, Marilize.
 */
public class Navigator {

    private String currentLink;
    private StackList<String> backLinks;
    private StackList<String> forwardLinks;

    /**
     * Constructor that initializes the class attributes.
     */
    Navigator() {
        this.currentLink = null;
        this.backLinks = new StackList<>("Back");
        this.forwardLinks = new StackList<>("Forward");
    }

    /**
     * This accessor method takes an object of type String​for the current requested link
     * and updates the backLinks and forwardLinks stacks.
     *
     * @param currentLink assigns field currentLink to currentLink parameter.
     */
    public void setCurrentLink(String currentLink) {
        if ((this.currentLink == null)) {
            this.currentLink = currentLink;
        } else {
            this.backLinks.push(this.currentLink);
            forwardLinks.clear();
            this.currentLink = currentLink;
        }
    }

    /**
     * Updates the currentLink to the link at the top of the backLinks stack.
     */
    public void goBack() {
        try {
            if (this.backLinks.isEmpty()) {
                throw new EmptyStackException();
            }
            this.forwardLinks.push(this.currentLink);
            this.currentLink = this.backLinks.pop();
        } catch (EmptyStackException e) {
            System.out.println("No more back links.");
        }
    }

    /**
     * Updates the currentLink to the link at the top of the forwardLinks stack.
     */
    public void goForward() {
        try {
            if (this.forwardLinks.isEmpty()) {
                throw new EmptyStackException();
            }
            this.backLinks.push(this.currentLink);
            this.currentLink = this.forwardLinks.pop();

        } catch (EmptyStackException e) {
            System.out.println("No forward links.");
        }
    }

    /**
     * Accessor method for the class attributes.
     *
     * @return field currentLink.
     */
    public String getCurrentLink() {
        return this.currentLink;
    }

    /**
     * Accessor method for the class attributes.
     *
     * @return field backLinks.
     */
    public StackList<String> getBackLinks() {
        return this.backLinks;
    }

    /**
     * Accessor method for the class attributes.
     *
     * @return fiel forwardLinks.
     */
    public StackList<String> getForwardLinks() {
        return this.forwardLinks;
    }
}
