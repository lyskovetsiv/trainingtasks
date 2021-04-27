package webdrivertasks.icanwin.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PasteCreationTest extends BaseTest {
    private static final String SYNTAX_HIGHLIGHTING = "Bash";
    private static final String TEXT_IN_MAIN_FORM = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                                    "git push origin master --force";
    private static final String TITLE = "how to gain dominance among developers";
    private static final String EXPIRATION_TIME = "how to gain dominance among developers";

    @Test
    public void pasteCreationTest() {
        mainPage.openPage()
                .setSyntaxHighlighting("Bash")
                .enterTextInMainForm("Hello from WebDriver")
                .setExpirationTime("10 Minutes")
                .enterPasteName("helloweb")
                .createNewPasteButtonClick();
    }

    @Test
    public void pasteCreationTestWithValidation() {
        mainPage.openPage()
                .setSyntaxHighlighting(SYNTAX_HIGHLIGHTING)
                .enterTextInMainForm(TEXT_IN_MAIN_FORM)
                .setExpirationTime(EXPIRATION_TIME)
                .enterPasteName(TITLE)
                .createNewPasteButtonClick();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(TITLE, mainPage.getTitleOfCreatedPaste(), "Title of the paste is incorrect");
        softAssert.assertEquals(TEXT_IN_MAIN_FORM, mainPage.getTextOfCreatedPaste(), "Text of the paste is incorrect");
        softAssert.assertEquals(SYNTAX_HIGHLIGHTING, mainPage.getSyntaxHighlighting(), "Syntax highlighting of the paste is incorrect");

        softAssert.assertAll();
    }

}
