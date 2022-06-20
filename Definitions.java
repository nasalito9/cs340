package edu.sfsu;


public enum Definitions {
    Arrow1("Arrow", "noun", "Here is one arrow: <IMG> -=>> </IMG>"),
    bookNoun1("Book", "noun", "A set of pages."),
    bookNoun2("Book", "noun", "A written work published in printed or electronic form."),
    bookVerb1("Book", "verb", "T arrange for someone to have a seat on a plane."),
    bookVerb2("Book", "verb", "To arrange something on a particular date."),
    distinctAdj1("Distinct", "adjective", "Familiar. Worked in Java."),
    distinctAdj2("Distinct", "adjective", "Unique. No duplicates. Clearly different or of a different kind."),
    distinctAdv1("Distinct", "adverb", "Uniquely. Written \"distinctly\"."),
    distinctNoun1("Distinct", "noun", "A keyword in this assignment."),
    distinctNoun2("Distinct", "noun", "A keyword in this assignment."),
    distinctNoun3("Distinct", "noun", "A keyword in this assignment."),
    distinctNoun4("Distinct", "noun", "An advanced serach option"),
    distinctNoun5("Distinct", "noun", "Distinct is a parameter in this assignment"),
    placeholderAdj1("Placeholder", "adjective", "To be updated..."),
    placeholderAdj2("Placeholder", "adjective", "To be updated..."),
    placeholderAdv1("Placeholder", "adverb", "To be updated..."),
    placeholderConj1("Placeholder", "conjunction", "To be updated..."),
    placeholderInterj1("Placeholder", "Interjection", "To be updated..."),
    placeholderNoun1("Placeholder", "noun", "To be updated..."),
    placeholderNoun2("Placeholder", "noun", "To be updated..."),
    placeholderNoun3("Placeholder", "noun", "To be updated..."),
    placeholderPrep1("Placeholder", "Preposition", "To be updated..."),
    placeholderPronoun1("Placeholder", "pronoun", "To be updated..."),
    placeholderVerb1("Placeholder", "verb", "To be updated..."),
    reverseAdj1("Reverse", "adjective", "On back side."),
    reverseAdj2("Reverse", "adjective", "Opposite to usual or previous arrangement."),
    reverseNoun1("Reverse", "noun", "A dictionary program's parameter."),
    reverseNoun2("Reverse", "noun", "Change to opposite direction."),
    reverseNoun3("Reverse", "noun", "The opposite"),
    reverseNoun4("Reverse", "noun", "To be updated"),
    reverseNoun5("Reverse", "noun", "To be updated"),
    reverseNoun6("Reverse", "noun", "To be updated"),
    reverseNoun7("Reverse", "noun", "To be updated"),
    reverseVerb1("Reverse", "verb", "Change something to opposite."),
    reverseVerb2("Reverse", "verb", "Go back."),
    reverseVerb3("Reverse", "verb", "Revoke ruling."),
    reverseVerb4("Reverse", "verb", "To be updated..."),
    reverseVerb5("Reverse", "verb", "To be updated..."),
    reverseVerb6("Reverse", "verb", "Turn something inside out"),
    plate1("Plate", "noun", "a flat dish, typically circular and made of china, from which food is eaten or served."),
    plate2("Plate", "noun", "dishes, bowls, cups, and other utensils made of gold, silver, or other metal."),
    plate3("Plate", "verb", "cover (a metal object) with a thin coating or film of a different metal."),
    plate4("Plate", "verb", "serve or arrange (food) on a plate or plates before a meal."),
    mat1("Mat", "noun", "a piece of coarse material placed on a floor for people to wipe their feet on."),
    mat2("Mat", "noun", "a small piece of cork, card, or fabric placed on a table or other surface to protect it from the heat or moisture of an object placed on it."),
    mat3("Mat", "verb", "tangle (something, especially hair) in a thick mass."),
    mat4("Mat", "adverb", "To be updated..."),
    mat5("Mat", "adjective", "To be updated..."),
    grenadine("Grenadine", "noun", "thin syrup made from pomegranate juice; used in mixed drinks."),
    pomegranate("Pomegranate", "noun", "shrub or small tree having large red many-seeded fruit."),
    hefty("Hefty", "adjective", "of considerable weight and size."),
    gladiolus("Gladiolus", "adjective", "any of numerous plants of the genus Gladiolus native chiefly to tropical and South Africa having sword-shaped leaves and one-sided spikes of brightly colored funnel-shaped flowers; widely cultivated."),
    pelter("Pelter", "adjective", "a thrower of missiles."),
    concretize("Concretize", "adverb", "make something concrete."),
    tamp("Tamp", "verb", "To press down tightly."),
    canoodle("Canoodle", "verb", "To fondle or pet affectionately."),
    tribunal("Tribunal", "noun", "An assembly to conduct judicial business."),
    chrome("Chrome", "noun", "To be updated..."),
    gibraltar("Gibraltar", "noun", "To be updated..."),
    zaccaroni("Zaccaroni", "noun", "To be updated..."),
    god("Shohei", "noun", "Shohei.");

    private final String word, tense, def;

    Definitions(String word, String tense, String def) {
        this.word = word;
        this.tense = tense;
        this.def = def;
    }

    public String getWord() {
        return word;
    }

    public String getTense() {
        return tense;
    }

    public String getDef() {
        return def;
    }



    @Override
    public String toString() {
        return word + " [" + tense + "] : " + def + "\n";
    }
}

