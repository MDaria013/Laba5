package com.example.lab5.books;


public class BookFactory {
    ReadingBook reading;
    GeneratorBook generatorBook = new GeneratorBook();

    public BookFactory(ReadingBook reading) {
        this.reading = reading;
    }

    public Book createBook() {
        Book book;
        double rn = Math.random();
        if (rn < 0.25) {
            book = createEngEd();
        } else if (rn>0.25 & rn < 0.5) {
            book = createEngFic();
        } else if (rn>0.5 & rn < 0.75) {
            book = createRusEd();
        } else {
            book = createRusFic();
        }
        return book;
    }

    public EnglishTextbook createEngEd() {
        return new EnglishTextbook(generatorBook.Generator(reading.getTitle_EngTextbook()), generatorBook.Generator(reading.getAuthor_EngTextbook()), generatorBook.Generator(reading.getUniversity_EngTextbook()));
    }

    public EnglishFiction createEngFic() {
        return new EnglishFiction(generatorBook.Generator(reading.getTitle_EngFiction()), generatorBook.Generator(reading.getAuthor_EngFiction()));
    }

    public RussianTextbook createRusEd() {
        return new RussianTextbook(generatorBook.genNameRusEd(reading.getTitle_RusTextbook()));
    }

    public RussianFiction createRusFic() {
        return new RussianFiction(generatorBook.Generator(reading.getTitle_RusFiction()),generatorBook.Generator(reading.getAuthor_RusFiction()));
    }


}
