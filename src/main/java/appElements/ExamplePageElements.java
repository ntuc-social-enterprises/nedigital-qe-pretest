package appElements;

public class ExamplePageElements {
    //Provide all the xpath elements
    /*
        [Name] -  variable to replace at the run time to avoid multiple xpaths. It helps us to pass the text that
        we need to identify them.
     */
    public static class Xpath{
        public static String h1Text = "//h1[text()='[Name]]']";
        public static String nameInputField = "//input[@id='developer-name']";
        public static String featuresCheckbox = "//input[@type='checkbox' and @name='[Name]']";
        public static String sliderValueSelection = "//div[@class='slider-value'][[Name]]";
        public static String osRadioButton = "//input[@type='radio' and @value='[Name]']";
    }

    //Provide all the ID elements
    public class Id{

    }
}
