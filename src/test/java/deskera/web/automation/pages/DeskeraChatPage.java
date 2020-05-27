package deskera.web.automation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DeskeraChatPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public DeskeraChatPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);	
	}
	
	/***************************  Deskera Chat Page PAGE ELEMENTS LOCATORS *******************/
	@FindBy(xpath = "//img[@class='wtf2-avatar avatar']")
	@CacheLookup
	private WebElement userLogo;
	@FindBy(xpath = "//span[@class='user-name']")
	@CacheLookup
	private WebElement userName;
	@FindBy(xpath = "//img[@class='wtf2-avatar avatar ng-tns-c35-7 ng-star-inserted']")
	@CacheLookup
	private WebElement companyLogo;
	@FindBy(xpath = "//div[@class='company-name']")
	@CacheLookup
	private WebElement companyName;
	@FindBy(xpath = "//wtf2-icon[contains(.,'keyboard_arrow_down')]")
	@CacheLookup
	private WebElement companyListArrow;
	@FindBy(xpath = "//input[contains(@placeholder,'Search Contacts, Favorite or Channels')]")
	@CacheLookup
	private WebElement contactsFavouriteSearchBox;
	@FindBy(xpath = "//label[contains(.,'Channels')]")
	@CacheLookup
	private WebElement channelsText;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'add')])[1]")
	@CacheLookup
	private WebElement addChannelButton;
	@FindBy(xpath = "//div[contains(@class,'contact-name ml-2 ellipsis')]")
	@CacheLookup
	private WebElement defaultChannel;
	@FindBy(xpath = "//label[contains(.,'Direct Messages')]")
	@CacheLookup
	private WebElement directMessageText;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'add')])[2]")
	@CacheLookup
	private WebElement addDirectMessageButton;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[1]")
	@CacheLookup
	private WebElement viewChannelIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'star_border')])[1]")
	@CacheLookup
	private WebElement starIcon;
	@FindBy(xpath = "//wtf2-icon[contains(.,'people')]")
	@CacheLookup
	private WebElement memberIcon ;
	
	/***************************  Chat Box ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//div[@class='ace_content']")
	@CacheLookup
	private WebElement chatContentBox;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Bold']")
	@CacheLookup
	private WebElement boldIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Italic']")
	@CacheLookup
	private WebElement italicIcon;
	@FindBy(xpath = "//wtf2-icon[contains(@aria-label,'Heading')]")
	@CacheLookup
	private WebElement headingIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Strike']")
	@CacheLookup
	private WebElement strikeIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Refrence']")
	@CacheLookup
	private WebElement referenceIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Link']")
	@CacheLookup
	private WebElement linkIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Unordered List']")
	@CacheLookup
	private WebElement unorderedListIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Ordered List']")
	@CacheLookup
	private WebElement orderedListIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Code Block']")
	@CacheLookup
	private WebElement codeBlockIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Table']")
	@CacheLookup
	private WebElement tableIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Attachment']")
	@CacheLookup
	private WebElement attachmentIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Reaction']")
	@CacheLookup
	private WebElement reactionIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Send']")
	@CacheLookup
	private WebElement sendIcon;
	
	
	
	
	
	private static String pageTitleText = "Deskera Cloud";
	
	
	/***********************************
	 * 
	 * Page objects manipulation methods
	 * 
	 *********************************/
	
	public void verifyPageTitle() {
		Assert.assertEquals(driver.getTitle(), pageTitleText);
	}

	// Common util for webdriver wait
	public void WDWait(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	
	public void verifyDeskeraChatPageElements() {
		WDWait(userLogo);
		userLogo.isDisplayed();
		userName.isDisplayed();
		companyLogo.isDisplayed();
		companyName.isDisplayed();
		companyListArrow.isDisplayed();
		contactsFavouriteSearchBox.isDisplayed();
		channelsText.isDisplayed();
		addChannelButton.isDisplayed();
		defaultChannel.isDisplayed();
		directMessageText.isDisplayed();
		addDirectMessageButton.isDisplayed();
		viewChannelIcon.isDisplayed();
		starIcon.isDisplayed();
		memberIcon.isDisplayed();
		chatContentBox.isDisplayed();
		boldIcon.isDisplayed();
		italicIcon.isDisplayed();
		headingIcon.isDisplayed();
		strikeIcon.isDisplayed();
		referenceIcon.isDisplayed();
		linkIcon.isDisplayed();
		unorderedListIcon.isDisplayed();
		orderedListIcon.isDisplayed();
		codeBlockIcon.isDisplayed();
		tableIcon.isDisplayed();
		attachmentIcon.isDisplayed();
		reactionIcon.isDisplayed();
		sendIcon.isDisplayed();
	}
	
}
