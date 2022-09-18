package com.smw.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.smw.common.valid.AddGroup;
import com.smw.common.valid.ListValue;
import com.smw.common.valid.UpdateGroup;
import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @NotNull(message = "修改必须指定品牌id", groups = UpdateGroup.class)
  @Null(message = "新增不能指定id", groups = AddGroup.class)
  @TableId
  private Long brandId;

  @NotBlank(
      message = "品牌名必须提交",
      groups = {AddGroup.class})
  private String name;

  @NotEmpty(groups = {AddGroup.class})
  @URL(
      message = "logo必须是一个合法的url地址",
      groups = {UpdateGroup.class, AddGroup.class})
  private String logo;

  private String descript;

  @ListValue(
      values = {0, 1},
      groups = {AddGroup.class})
  private Integer showStatus;

  @NotEmpty(groups = {AddGroup.class})
  @Pattern(
      regexp = "^[a-zA-Z]$",
      message = "首字母必须是一个字母",
      groups = {UpdateGroup.class, AddGroup.class})
  private String firstLetter;

  @NotNull(groups = {AddGroup.class})
  @Min(
      value = 0,
      message = "排序必须大于零",
      groups = {UpdateGroup.class, AddGroup.class})
  private Integer sort;
}
