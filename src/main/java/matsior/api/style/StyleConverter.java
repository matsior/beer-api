package matsior.api.style;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Component
@Converter(autoApply = true)
public class StyleConverter implements AttributeConverter<Style, String> {
    @Override
    public String convertToDatabaseColumn(Style style) {
        if (style == null) {
            return null;
        }
        return style.name();
    }

    @Override
    public Style convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Style.valueOf(name);
    }
}
