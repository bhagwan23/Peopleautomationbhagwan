package deskera.web.automation.go.pages;

import java.util.Random;

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
	
	private WebElement userLogo;
	@FindBy(xpath = "//span[@class='user-name']")
	
	private WebElement userName;
	@FindBy(xpath = "//img[contains(@class,'wtf2-avatar avatar ng-tns')]")
	
	private WebElement companyLogo;
	@FindBy(xpath = "//div[@class='company-name']")
	
	private WebElement companyName;
	@FindBy(xpath = "//wtf2-icon[contains(.,'keyboard_arrow_down')]")
	
	private WebElement companyListArrow;
	@FindBy(xpath = "//input[contains(@placeholder,'Search Contacts, Favorite or Channels')]")
	
	private WebElement contactsFavouriteSearchBox;
	@FindBy(xpath = "//label[contains(.,'Channels')]")
	
	private WebElement channelsText;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'add')])[1]")
	
	private WebElement addChannelButton;
	@FindBy(xpath = "//div[contains(@class,'contact-name ml-2 ellipsis')]")
	
	private WebElement defaultChannel;
	@FindBy(xpath = "//label[contains(.,'Direct Messages')]")
	
	private WebElement directMessageText;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'add')])[2]")
	
	private WebElement addDirectMessageButton;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[1]")
	
	private WebElement viewChannelIcon;
	@FindBy(xpath = "(//wtf2-icon[contains(.,'star_border')])[1]")
	
	private WebElement starIcon;
	@FindBy(xpath = "//wtf2-icon[contains(.,'people')]")
	
	private WebElement memberIcon ;
	private static String pageTitleText = "Deskera Cloud";
	/***************************  Chat Box ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//div[@class='ace_content']")
	
	private WebElement chatContentBox;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Bold']")
	
	private WebElement boldIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Italic']")
	
	private WebElement italicIcon;
	@FindBy(xpath = "//wtf2-icon[contains(@aria-label,'Heading')]")
	
	private WebElement headingIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Strike']")
	
	private WebElement strikeIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Refrence']")
	
	private WebElement referenceIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Link']")
	
	private WebElement linkIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Unordered List']")
	
	private WebElement unorderedListIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Ordered List']")
	
	private WebElement orderedListIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Code Block']")
	
	private WebElement codeBlockIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Table']")
	
	private WebElement tableIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Attachment']")
	
	private WebElement attachmentIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Reaction']")
	
	private WebElement reactionIcon;
	@FindBy(xpath = "//wtf2-icon[@aria-label='Send']")
	
	private WebElement sendIcon;
	@FindBy(xpath = "//div//a[contains(text(),'Help')]")
	
	private WebElement helpLink;
	
	
	/***************************  Create Channel  ELEMENTS LOCATORS *******************/
	
	@FindBy(xpath = "//div[contains(text(),'Create channel')]")
	
	private WebElement createChannelHeader;
	@FindBy(xpath = "//div[contains(text(),'Create channel')]//following::wtf2-icon[contains(text(),'close')]")
	
	private WebElement createChannelCloseIcon;
	@FindBy(xpath = "//wtf2-label[contains(text(),'Name')]")
	
	private WebElement channelNamelabel;
	@FindBy(xpath = "//input[@formcontrolname='channel_name']")
	
	private WebElement channelNameInputBox;
	@FindBy(xpath = "//wtf2-icon[contains(text(),'public')]")
	
	private WebElement publicChannelIcon;
	@FindBy(xpath = "//span[contains(text(),'Public')]")
	
	private WebElement publicChannelType;
	@FindBy(xpath = "//wtf2-icon[contains(text(),'lock')]")
	
	private WebElement privateChannelIcon;
	@FindBy(xpath = "//span[contains(text(),'Private')]")
	
	private WebElement privateChannelType;
	@FindBy(xpath = "//label[contains(text(),'Members')]")
	
	private WebElement membersLabel;
	@FindBy(xpath = "//input[contains(@placeholder,'Members')]")
	
	private WebElement membersInputBox;
	@FindBy(xpath = "//wtf2-label[contains(text(),'Description')]")
	
	private WebElement descriptionLabel;
	@FindBy(xpath = "//textarea[contains(@formcontrolname,'channel_desc')]")
	
	private WebElement descriptionTextArea;
	@FindBy(xpath = "//span[contains(text(),'CREATE')]")
	
	private WebElement createChannelButton;
	@FindBy(xpath = "//span[contains(text(),'CANCEL')]")
	
	private WebElement cancelChannelButton;
	String enteredchannelname;
	
	
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
		WDWait(userName);
		userName.isDisplayed();
		WDWait(companyLogo);
		companyLogo.isDisplayed();
		WDWait(companyName);
		companyName.isDisplayed();
		companyListArrow.isDisplayed();
		contactsFavouriteSearchBox.isDisplayed();
		channelsText.isDisplayed();
		addChannelButton.isDisplayed();
		defaultChannel.isDisplayed();
		directMessageText.isDisplayed();
		addDirectMessageButton.isDisplayed();
		WDWait(viewChannelIcon);
		viewChannelIcon.isDisplayed();
		WDWait(starIcon);
		starIcon.isDisplayed();
		WDWait(memberIcon);
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
		helpLink.isDisplayed();
	}
	
	public void clickAddChannelIcon(){
		addChannelButton.click();
	}
	
	public void verifyCreateChannelWindowElements() {
		WDWait(createChannelHeader);
		createChannelHeader.isDisplayed();
		createChannelCloseIcon.isDisplayed();
		channelNamelabel.isDisplayed();
		channelNameInputBox.isDisplayed();
		publicChannelIcon.isDisplayed();
		publicChannelType.isDisplayed();
		privateChannelIcon.isDisplayed();
		privateChannelType.isDisplayed();
		membersLabel.isDisplayed();
		membersInputBox.isDisplayed();
		descriptionLabel.isDisplayed();
		descriptionTextArea.isDisplayed();
		createChannelButton.isDisplayed();
		cancelChannelButton.isDisplayed();
	}
	
	public void enterPublicChannelDetails(){
		Random rand = new Random();
		String id = String.format("%04d", rand.nextInt(1000));
		WDWait(channelNameInputBox);
		channelNameInputBox.sendKeys("Public Channel "+id);
		enteredchannelname=channelNameInputBox.getAttribute("value");	
		publicChannelType.click();
		descriptionTextArea.sendKeys("Test description");
	}
	
	public void clickCreateChannelButton(){
		createChannelButton.click();
	}
	
	public void verifyCreatedChannel(){
		if(driver.getPageSource().contains(enteredchannelname)){
			System.out.println("Text is present");
			}
		else{
			Assert.fail();
			}
	}
}
