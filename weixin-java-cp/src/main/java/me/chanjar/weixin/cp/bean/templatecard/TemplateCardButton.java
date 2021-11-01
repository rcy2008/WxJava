package me.chanjar.weixin.cp.bean.templatecard;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * 按钮列表，该字段可为空数组，但有数据的话需确认对应字段是否必填，列表长度不超过6
 * @author yzts
 * @date 2021/9/22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TemplateCardButton  implements Serializable {
  private static final long serialVersionUID = -4826551822490837002L;

  /**
   * 按钮文案，建议不超过10个字
   */
  private String text;
  /**
   * 按钮样式，目前可填1~4，不填或错填默认1
   */
  private Integer style;
  /**
   * 按钮key值，用户点击后，会产生回调事件将本参数作为EventKey返回，回调事件会带上该key值，最长支持1024字节，不可重复
   */
  private String key;

  public JsonObject toJson() {
    JsonObject btnObject = new JsonObject();


    btnObject.addProperty("text", this.getText());

    if (null != this.getStyle()) {
      btnObject.addProperty("style", this.getStyle());
    }
    btnObject.addProperty("key", this.getKey());
    return btnObject;
  }
}
