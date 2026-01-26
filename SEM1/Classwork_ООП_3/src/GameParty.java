package SEM1.Classwork_ООП_3.src;

public class GameParty {
    public static GameCharacter[] partyMembers = new GameCharacter[100]; // не хочу делать систему с массивом и его расширением каждый раз, так как уже делал подобное в studentsООП. Сделаю другую систему, максимальное количество будет ограничено
    public static int characters_int = 0;

    public static void addCharacter(GameCharacter character) {
        assert characters_int < 100;
        characters_int += 1;
        partyMembers[characters_int] = character;
    }

    public static void removeCharacter(String name) {
        int i = 0;
        boolean flag = false;
        for (GameCharacter g: partyMembers) {
            if (g.getName().equals(name)) {flag = true;}
            i++;
            partyMembers[i-1] = partyMembers[i];
        }
    }

    public static void displayPartyInfo() {
        for(GameCharacter g: partyMembers) {
            if (g != null) {
            g.displayInfo();}
        }
    }

    public static void useAllSpecialAbilities() {
        for(GameCharacter g: partyMembers) {
            if (g != null) {
                g.useSpecialAbility();}
        }
    }

    public static GameCharacter[] findCharacterByClass(String className) {
        GameCharacter[] ret = new GameCharacter[100];
        int i =0;
        for(GameCharacter g: partyMembers) {
            if (g.getClass().toString().equals(className)) {
                ret[i] = g;}
            i++;
        }
        return ret;
    }

    public static double calculatePartyPower() {
        double power = 0;
        for(GameCharacter g: partyMembers) {
            if (g != null) {
                power += g.getMana();}
        }
        return power;
    }

}
