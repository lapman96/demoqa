package org.demoqa.elements_pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.demoqa.utils.PagePaths.BASE_UI_URL;
import static org.demoqa.utils.PagePaths.CHECKBOX_BOX_PAGE_URL;


@NoArgsConstructor
public class CheckBoxElementPage extends BaseElementPage {
    @Getter
    private static final String PAGE_URL = BASE_UI_URL + CHECKBOX_BOX_PAGE_URL;

    private final SelenideElement expandAllCheckboxesButton = $(By.cssSelector("button[title=\"Expand all\"]"));

    private final SelenideElement collapseAllCheckboxesButton = $(By.cssSelector("button[title=\"Collapse all\"]"));

    @Getter
    private final ElementsCollection selectedCheckboxes = $$(By.cssSelector("span[class=\"text-success\"]"));

    @Getter
    private final ElementsCollection checkboxes = $$(By.cssSelector("span[class=\"rct-title\"]"));

    @Override
    public CheckBoxElementPage openPage() {
        open(PAGE_URL);
        return this;
    }

    private SelenideElement getCheckboxByName(String checkboxName) {
        return $(By.xpath(String.format("//span[text()='%s']/preceding-sibling::span[2]//*[local-name() = 'svg']",checkboxName)));
    }

    public boolean isCheckboxUnchecked(String checkboxName) {
        SelenideElement checkbox = getCheckboxByName(checkboxName);
        return checkbox.has(Condition.cssClass("rct-icon-uncheck"));
    }

    public boolean isCheckboxHalfChecked(String checkboxName) {
        SelenideElement checkbox = getCheckboxByName(checkboxName);
        return checkbox.has(Condition.cssClass("rct-icon-half-check"));
    }

    public boolean isCheckboxChecked(String checkboxName) {
        SelenideElement checkbox = getCheckboxByName(checkboxName);
        return checkbox.has(Condition.cssClass("rct-icon-check"));
    }

    public CheckBoxElementPage clickOnTheExpandAllCheckboxesButton() {
        expandAllCheckboxesButton.click();
        return this;
    }

    public CheckBoxElementPage clickOnTheCollapseAllCheckboxesButton() {
        collapseAllCheckboxesButton.click();
        return this;
    }

    public CheckBoxElementPage tickTheCheckboxByName(String checkboxName) {
        SelenideElement checkbox = getCheckboxByName(checkboxName);
        if(isCheckboxUnchecked(checkboxName) || isCheckboxHalfChecked(checkboxName)) {
            checkbox.click();
        }
        return this;
    }

    public CheckBoxElementPage untickTheCheckboxByName(String checkboxName) {
        SelenideElement checkbox = getCheckboxByName(checkboxName);
        if(isCheckboxChecked(checkboxName)) {
            checkbox.click();
        }
        return this;
    }

    public ElementsCollection getVisibleCheckboxes() {
        return checkboxes.filter(Condition.visible);
    }
}
