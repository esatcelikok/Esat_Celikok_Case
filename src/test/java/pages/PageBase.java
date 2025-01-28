package pages;

import utility.Utility;
import utility.library.ElementLibrary;
import utility.library.FlowsLibrary;


public class PageBase extends Utility {

    private final ElementLibrary elementsLibrary;
    private final FlowsLibrary flowsLibrary;

    public PageBase() {
        elementsLibrary = new ElementLibrary();
        flowsLibrary=new FlowsLibrary();
    }

    public ElementLibrary getElementLibrary() {
        return  elementsLibrary;
    }
    public FlowsLibrary getFlowsLibrary() {
        return  flowsLibrary;
    }
}