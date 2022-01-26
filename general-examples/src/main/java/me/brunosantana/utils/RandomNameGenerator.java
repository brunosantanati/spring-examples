package me.brunosantana.utils;

public class RandomNameGenerator implements NameGenerator{

    @Override
    public String getName() {
        String[] names = {"Bruno", "Paulo", "Marcelo", "Lucas"};

        int min = 0;
        int max = 3;
        int randomNumber = (int)Math.floor(Math.random()*(max-min+1)+min);

        return names[randomNumber];
    }

}
