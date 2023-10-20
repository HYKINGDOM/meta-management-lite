package com.java.meta.common.base;

import java.io.Serializable;
import java.util.LinkedHashMap;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author hy
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MetaResult extends LinkedHashMap<String, Object> implements Serializable {




}
