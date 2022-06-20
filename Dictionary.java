package edu.sfsu;

public class Dictionary {
    private Definitions definition;

    public Dictionary() {
    }

    public Dictionary(Definitions definition) {
        this.definition = definition;
    }

    public Definitions getDefinition() {
        return definition;
    }

    public void setDefinition(Definitions definition) {
        this.definition = definition;
    }

    public String getWord(Definitions definition){
        return definition.getWord();
    }
}
