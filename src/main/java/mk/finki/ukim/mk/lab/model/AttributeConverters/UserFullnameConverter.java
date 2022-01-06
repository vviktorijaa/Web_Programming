package mk.finki.ukim.mk.lab.model.AttributeConverters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserFullnameConverter implements AttributeConverter<UserFullName, String> {

    private static final String SEPARATOR = ", ";

    @Override
    public String convertToDatabaseColumn(UserFullName userFullName) {
        if (userFullName == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        if (userFullName.getSurname() != null && !userFullName.getSurname()
                .isEmpty()) {
            sb.append(userFullName.getSurname());
            sb.append(SEPARATOR);
        }

        if (userFullName.getName() != null
                && !userFullName.getName().isEmpty()) {
            sb.append(userFullName.getName());
        }

        return sb.toString();
    }

    @Override
    public UserFullName convertToEntityAttribute(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        String[] pieces = s.split(SEPARATOR);

        if (pieces == null || pieces.length == 0) {
            return null;
        }

        UserFullName personName = new UserFullName();
        String firstPiece = !pieces[0].isEmpty() ? pieces[0] : null;
        if (s.contains(SEPARATOR)) {
            personName.setSurname(firstPiece);

            if (pieces.length >= 2 && pieces[1] != null
                    && !pieces[1].isEmpty()) {
                personName.setName(pieces[1]);
            }
        } else {
            personName.setName(firstPiece);
        }

        return personName;
    }
}
