package cn.ashersu.omni.model.service.openai.item;

import cn.ashersu.omni.model.billing.BillingUsage;
import cn.ashersu.omni.model.billing.Subscription;
import cn.ashersu.omni.model.service.openai.BaseOpenAIService;
import cn.ashersu.omni.model.service.openai.OpenAIConfig;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * 提供OpenAI账单相关API调用功能
 */
public class BillingService extends BaseOpenAIService {
    
    public BillingService(OpenAIConfig config) {
        super(config);
    }
    
    /**
     * 获取订阅信息
     * 
     * @return 订阅信息
     */
    public Subscription subscription() {
        return execute(getApi().subscription());
    }
    
    /**
     * 获取账单使用情况
     * 
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 账单使用情况
     */
    public BillingUsage billingUsage(@NotNull LocalDate startDate, @NotNull LocalDate endDate) {
        return execute(getApi().billingUsage(startDate, endDate));
    }
} 