package lesson03;

import java.util.List;

public record Student(String name, int age, List<Grade> grades, String school, Address address) {}