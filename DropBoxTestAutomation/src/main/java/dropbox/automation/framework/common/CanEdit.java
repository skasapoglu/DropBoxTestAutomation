package dropbox.automation.framework.common;

import org.openqa.selenium.By;

/**
 * Enumeration element for Can Edit Field on creation of new folder.
 * 
 * @author Sabahattin Kasapoglu
 *
 */
public enum CanEdit {

	CAN_EDIT(By.xpath("//div[contains(text(),'Can edit')]")), CAN_VIEW(By.xpath("//div[contains(text(),'Can view')]"));

	private By fieldElement;

	CanEdit(By element) {
		this.fieldElement = element;
	}

	public By getValue() {
		return this.fieldElement;
	}

}
