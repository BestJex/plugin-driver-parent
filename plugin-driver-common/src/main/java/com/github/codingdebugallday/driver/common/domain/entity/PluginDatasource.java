package com.github.codingdebugallday.driver.common.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.github.codingdebugallday.driver.common.infra.annotations.DriverId;
import lombok.*;

/**
 * <p>
 * 插件数据源映射类
 * </p>
 *
 * @author isaac 2020/7/1 16:10
 * @since 1.0
 */
@SuppressWarnings("unused")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PluginDatasource implements Serializable {

    private static final long serialVersionUID = 3106933368424452675L;

    @NotBlank
    private String datasourceCode;
    private String datasourceDescription;
    @NotBlank
    private String datasourceType;
    @NotBlank
    private String datasourceClass;
    @NotNull
    @DriverId
    private Long datasourceDriverId;
    @DriverId
    private Long sessionDriverId;
    private String settingsInfo;
    /**
     * 主要是查询时带出来
     */
    private PluginDriver sessionDriver;
    private PluginDriver datasourceDriver;

    @Builder.Default
    private Integer enabledFlag = 1;
    @Builder.Default
    private Long tenantId = 0L;
    private LocalDateTime lastUpdateDate;

    /**
     * 由于未使用mysql储存，直接写到redis，故这里重写setter/getter
     */

    public LocalDateTime getLastUpdateDate() {
        return Objects.isNull(lastUpdateDate) ? LocalDateTime.now() : lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = Objects.isNull(lastUpdateDate) ? LocalDateTime.now() : lastUpdateDate;
    }
}
