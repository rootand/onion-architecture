//
// Feel free to use these solutions in your work.
//
package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author  aleksey.n.bykov@gmail.com
 * @version 1.0
 * @since   2019-10-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "SomeDictionaryDto: some dictionary for whitepappers")
public class SomeDictionaryDto {

    @ApiModelProperty("identifier of the item")
    private Long id;

    @ApiModelProperty("name of the item")
    private String name;
}