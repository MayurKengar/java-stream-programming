void main() {
    var words = List.of("java", "programming");

    List<Character> characters = words.stream()
            .flatMap(word -> word.chars()
                    .mapToObj(ch -> (char) ch))
            .toList();

    System.out.println(characters);
}
