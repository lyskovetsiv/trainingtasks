package webdrivertasks.icanwin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasteCreationTest extends BaseTest {
    private static final String SYNTAX_HIGHLIGHTING = "Bash";
    private static final String TEXT_IN_MAIN_FORM = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                                    "git push origin master --force";
    private static final String TITLE = "how to gain dominance among developers";

    @Test
    public void pasteCreationTest() throws InterruptedException {
        mainPage.openPage()
                .setSyntaxHighlighting("Bash")
                .enterTextInMainForm("Hello from WebDriver")
                .setExpirationTime("10 Minutes")
                .enterPasteName("helloweb")
                .createNewPasteButtonClick();
        Thread.sleep(10000);
    }

    @Test
    public void pasteCreationTestWithValidation() {
        mainPage.openPage()
                .setSyntaxHighlighting(SYNTAX_HIGHLIGHTING)
                .enterTextInMainForm(TEXT_IN_MAIN_FORM)
                .setExpirationTime("10 Minutes")
                .enterPasteName(TITLE)
                .createNewPasteButtonClick();
        Assert.assertEquals(TITLE, mainPage.getTitleOfCreatedPaste(), "Title of the paste is incorrect");
        Assert.assertEquals(TEXT_IN_MAIN_FORM, mainPage.getTextOfCreatedPaste(), "Text of the paste is incorrect");
        Assert.assertEquals(SYNTAX_HIGHLIGHTING, mainPage.getSyntaxHighlighting(), "Syntax highlighting of the paste is incorrect");
    }

}
