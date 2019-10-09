//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.component.validators;

import alekseybykov.portfolio.component.entities.Whitepapper;
import alekseybykov.portfolio.component.entities.WhitepapperMetadata;
import alekseybykov.portfolio.component.exceptions.ValidationException;
import alekseybykov.portfolio.component.registries.WhitepapperMetadataRegistry;
import alekseybykov.portfolio.component.services.validator.Action;
import alekseybykov.portfolio.component.services.validator.WhitepapperMetadataValidator;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@DisplayName("Tests for metadata validation")
class WhitepapperMetadataValidatorTest {

    private final WhitepapperMetadataRegistry registry = mock(WhitepapperMetadataRegistry.class);
    private WhitepapperMetadataValidator validator = new WhitepapperMetadataValidator(registry);

    private final String validatorCanonicalName = WhitepapperMetadataValidator.class.getCanonicalName();

    @Test
    @DisplayName("Upload file without metadata")
    void testValidateNullMetadata() {
        WhitepapperMetadata metadata = null;
        ValidationException thrown = assertThrows(ValidationException.class,
                () -> validator.validate(metadata, Action.CREATE));

        assertEquals(thrown.getMessage(), format("%s: [%s]", validatorCanonicalName,
                "Metadata must be presented"));
    }

    @Test
    @DisplayName("Pass metadata with empty name")
    void testValidateMetadataWithEmptyNameWhenUpload() {
        LocalDate now = LocalDate.now();
        WhitepapperMetadata metadata = WhitepapperMetadata.builder().name(StringUtils.EMPTY).type("some type")
                .registrationDate(now).registrationNumber("REG/N-123").build();

        ValidationException thrown = assertThrows(ValidationException.class,
                () -> validator.validate(metadata, Action.CREATE));

        assertEquals(thrown.getMessage(),
                format("%s: [%s]", validatorCanonicalName, "The name is mandatory field"));
    }

    @Test
    @DisplayName("Pass metadata with too long name")
    void testValidateMetadataWithLongNameWhenEdit() {
        LocalDate now = LocalDate.now();
        WhitepapperMetadata whitepapperMetadata = WhitepapperMetadata.builder()
                .whitepapper(Whitepapper.builder().id(NumberUtils.LONG_ONE).build())
                .name(RandomStringUtils.random(501)).type("some type").registrationDate(now)
                .registrationNumber("REG/N-123").build();

        ValidationException thrown = assertThrows(ValidationException.class,
                () -> validator.validate(whitepapperMetadata, Action.UPDATE));

        assertEquals(thrown.getMessage(), format("%s: [%s]", validatorCanonicalName,
                "The name cannot contain more than 500 characters"));
    }

    // and so on ...
}
