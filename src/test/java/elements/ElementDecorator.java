package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ElementDecorator extends DefaultFieldDecorator {
    private WebDriver driver;

    public ElementDecorator(ElementLocatorFactory factory, WebDriver driver) {
        super(factory);
        this.driver = driver;
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        return isElementCustom(field) ?
                createElement(loader, factory.createLocator(field), field.getType())
                : super.decorate(loader, field);
    }

    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        try {
            return clazz.getConstructor(WebElement.class, WebDriver.class).newInstance(proxy, driver);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new AssertionError("Web element can not be represented as " + clazz);
        }
    }

    private boolean isElementCustom(Field field) {
        return CustomElement.class.isAssignableFrom(field.getType());
    }


}
