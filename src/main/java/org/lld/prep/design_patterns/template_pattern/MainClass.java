package org.lld.prep.design_patterns.template_pattern;

public class MainClass {
    public static void main(String[] args) {
        Beverage coffe = new Coffee();
        Beverage tea = new Tea();

        System.out.println("Making tea: ");
        tea.prepareRecipe();

        System.out.println("Making coffee: ");
        coffe.prepareRecipe();
    }
}
