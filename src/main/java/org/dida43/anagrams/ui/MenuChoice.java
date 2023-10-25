package org.dida43.anagrams.ui;

public enum MenuChoice {

    INVALID_CHOICE(0),
    CHECK_ANAGRAMS(1),
    DISPLAY_ANAGRAMS(2),
    EXIT(3);

    private final int choiceValue;

    MenuChoice(int choiceValue) {
        this.choiceValue = choiceValue;
    }

    public int getChoiceValue() {
        return choiceValue;
    }

    public static MenuChoice fromChoiceValue(int choiceValue) {
        for (MenuChoice menuChoice : values()) {
            if (menuChoice.getChoiceValue() == choiceValue) {
                return menuChoice;
            }
        }
        return null;
    }
}
