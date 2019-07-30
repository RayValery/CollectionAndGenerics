package Map;

public class WordWrapper implements Comparable<WordWrapper>{
    private final String word;
    private final Integer count;

    public WordWrapper(String word, Integer count){
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public int compareTo(WordWrapper o) {
        if (this.count<o.count){return 1;}
        else if (this.count>o.count){return -1;}
        else{return(this.getWord().compareTo(o.getWord()));}
    }
}
