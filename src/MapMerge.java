void main() {
    var sentence = "The curious cat cat wandered through the quiet quiet garden looking for something something unexpected";
    var map = new HashMap<String, Integer>();
    for (String word : sentence.split(" ")){
        map.merge(word.toLowerCase(), 1, Integer::sum);
    }
    IO.println(map);
}