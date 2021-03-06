package alekseybykov.portfolio.whitepappers.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aleksey Bykov
 * @since 08.09.2019
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "FileUploadDto: file upload result")
public class FileUploadDto {

    @ApiModelProperty("Identifier of the uploaded file")
    private Long id;
}
