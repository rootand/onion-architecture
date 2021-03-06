package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "IdsDto: Identifier's list")
public class IdsDto {

    @ApiModelProperty("Identifier's list")
    @Singular
    private List<Long> ids;
}
