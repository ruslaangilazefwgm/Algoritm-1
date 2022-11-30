package com.example.algorithm1spring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Objects;

public class StringListRealizationTests {
    private StringListRealization stringListRealization;

    @BeforeEach
    public void setUp() {
        this.stringListRealization = new StringListRealization(10);
    }

    @Test
    public void addTest() {
        stringListRealization.add("test1");
        assert stringListRealization.contains("test1");
    }

    @Test
    public void addWithIndexTest() {
        stringListRealization.add(0, "test2");
        Assertions.assertThat(stringListRealization.indexOf("test2")).isEqualTo(0);
    }

    @Test
    public void setTest() {
        stringListRealization.add(0, "test2");
        stringListRealization.set(0, "test3");
        Assertions.assertThat(stringListRealization.get(0).contains("test3"));
    }

    @Test
    public void removeTest() {
        stringListRealization.add(0, "test2");
        stringListRealization.remove("test2");
        boolean e = stringListRealization.contains("test2");
        Assertions.assertThat(e = false);
    }

    @Test
    public void removeWithIndexTest() {
        stringListRealization.add(0, "test2");
        stringListRealization.remove("test2");
        Assertions.assertThat(stringListRealization.get(0) == null);
    }

    @Test
    public void containsTest() {
        stringListRealization.add(0, "test2");
        boolean e = stringListRealization.contains("test2");
        Assertions.assertThat(e = true);
    }

    @Test
    public void indexOfTest() {
        stringListRealization.add(0, "test2");
        Assertions.assertThat(stringListRealization.indexOf("test2") == 0);
    }

    @Test
    public void lastIndexOfTest() {
        stringListRealization.add(0, "test2");
        stringListRealization.add(1, "test3");
        stringListRealization.add(2, "test4");
        stringListRealization.add(3, "test5");
        Assertions.assertThat(stringListRealization.lastIndexOf("test5") == 3);
    }

    @Test
    public void getTest() {
        stringListRealization.add(0, "test5");
        Assertions.assertThat(Objects.equals(stringListRealization.get(0), "Test5"));
    }

    @Test
    public void equalsTest() {
        stringListRealization.add(0, "test5");
        StringListRealization result = new StringListRealization(10);
        result.add(0, "test5");
        Assertions.assertThat(this.stringListRealization.equals(result));
    }

    @Test
    public void sizeTest() {
        stringListRealization.add(0, "test5");
        Assertions.assertThat(this.stringListRealization.size() == 1);
    }
    @Test
    public void isEmptyTest() {
        boolean e = stringListRealization.isEmpty();
        Assertions.assertThat(e = true);
    }
    @Test
    public void clearTest() {
        stringListRealization.add(0, "test5");
        stringListRealization.clear();
        boolean e = stringListRealization.isEmpty();
        Assertions.assertThat(e = true);
    }

    @Test
    public void toArrayTest() {
        stringListRealization.add(0, "test5");
        String[] result = stringListRealization.toArray();
        Assertions.assertThat(this.stringListRealization.equals(result));
    }



}
