package com.auth.sunia.star247.logs.aspect;


import cn.hutool.core.util.StrUtil;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;


/**
 * @Author star362
 * @Date 2023/7/7 17:23
 * @Description: TODO
 */
public class RequestInfo implements Serializable {
    private static final long serialVersionUID = -5874472232861587583L;
    private String bid;
    private String httpMethod;
    private String url;
    private Map<String, Object> requestParams;
    private Map<String, Object> requestHeaders;
    private String classMethod;
    private String ip;
    private Long timeCost;
    private String actionGroup;
    private String action;
    private Object result;
    private String exception;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Boolean itsOk() {
        return StrUtil.hasBlank(this.exception);
    }

    public RequestInfo() {
    }

    public String getBid() {
        return this.bid;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getUrl() {
        return this.url;
    }

    public Map<String, Object> getRequestParams() {
        return this.requestParams;
    }

    public Map<String, Object> getRequestHeaders() {
        return this.requestHeaders;
    }

    public String getClassMethod() {
        return this.classMethod;
    }

    public String getIp() {
        return this.ip;
    }

    public Long getTimeCost() {
        return this.timeCost;
    }

    public String getActionGroup() {
        return this.actionGroup;
    }

    public String getAction() {
        return this.action;
    }

    public Object getResult() {
        return this.result;
    }

    public String getException() {
        return this.exception;
    }

    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    public void setBid(final String bid) {
        this.bid = bid;
    }

    public void setHttpMethod(final String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public void setRequestParams(final Map<String, Object> requestParams) {
        this.requestParams = requestParams;
    }

    public void setRequestHeaders(final Map<String, Object> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    public void setClassMethod(final String classMethod) {
        this.classMethod = classMethod;
    }

    public void setIp(final String ip) {
        this.ip = ip;
    }

    public void setTimeCost(final Long timeCost) {
        this.timeCost = timeCost;
    }

    public void setActionGroup(final String actionGroup) {
        this.actionGroup = actionGroup;
    }

    public void setAction(final String action) {
        this.action = action;
    }

    public void setResult(final Object result) {
        this.result = result;
    }

    public void setException(final String exception) {
        this.exception = exception;
    }

    public void setStartTime(final LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(final LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RequestInfo)) {
            return false;
        } else {
            RequestInfo other = (RequestInfo) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$timeCost = this.getTimeCost();
                Object other$timeCost = other.getTimeCost();
                if (this$timeCost == null) {
                    if (other$timeCost != null) {
                        return false;
                    }
                } else if (!this$timeCost.equals(other$timeCost)) {
                    return false;
                }

                Object this$bid = this.getBid();
                Object other$bid = other.getBid();
                if (this$bid == null) {
                    if (other$bid != null) {
                        return false;
                    }
                } else if (!this$bid.equals(other$bid)) {
                    return false;
                }

                Object this$httpMethod = this.getHttpMethod();
                Object other$httpMethod = other.getHttpMethod();
                if (this$httpMethod == null) {
                    if (other$httpMethod != null) {
                        return false;
                    }
                } else if (!this$httpMethod.equals(other$httpMethod)) {
                    return false;
                }

                label158:
                {
                    Object this$url = this.getUrl();
                    Object other$url = other.getUrl();
                    if (this$url == null) {
                        if (other$url == null) {
                            break label158;
                        }
                    } else if (this$url.equals(other$url)) {
                        break label158;
                    }

                    return false;
                }

                label151:
                {
                    Object this$requestParams = this.getRequestParams();
                    Object other$requestParams = other.getRequestParams();
                    if (this$requestParams == null) {
                        if (other$requestParams == null) {
                            break label151;
                        }
                    } else if (this$requestParams.equals(other$requestParams)) {
                        break label151;
                    }

                    return false;
                }

                Object this$requestHeaders = this.getRequestHeaders();
                Object other$requestHeaders = other.getRequestHeaders();
                if (this$requestHeaders == null) {
                    if (other$requestHeaders != null) {
                        return false;
                    }
                } else if (!this$requestHeaders.equals(other$requestHeaders)) {
                    return false;
                }

                label137:
                {
                    Object this$classMethod = this.getClassMethod();
                    Object other$classMethod = other.getClassMethod();
                    if (this$classMethod == null) {
                        if (other$classMethod == null) {
                            break label137;
                        }
                    } else if (this$classMethod.equals(other$classMethod)) {
                        break label137;
                    }

                    return false;
                }

                label130:
                {
                    Object this$ip = this.getIp();
                    Object other$ip = other.getIp();
                    if (this$ip == null) {
                        if (other$ip == null) {
                            break label130;
                        }
                    } else if (this$ip.equals(other$ip)) {
                        break label130;
                    }

                    return false;
                }

                Object this$actionGroup = this.getActionGroup();
                Object other$actionGroup = other.getActionGroup();
                if (this$actionGroup == null) {
                    if (other$actionGroup != null) {
                        return false;
                    }
                } else if (!this$actionGroup.equals(other$actionGroup)) {
                    return false;
                }

                Object this$action = this.getAction();
                Object other$action = other.getAction();
                if (this$action == null) {
                    if (other$action != null) {
                        return false;
                    }
                } else if (!this$action.equals(other$action)) {
                    return false;
                }

                label109:
                {
                    Object this$result = this.getResult();
                    Object other$result = other.getResult();
                    if (this$result == null) {
                        if (other$result == null) {
                            break label109;
                        }
                    } else if (this$result.equals(other$result)) {
                        break label109;
                    }

                    return false;
                }

                label102:
                {
                    Object this$exception = this.getException();
                    Object other$exception = other.getException();
                    if (this$exception == null) {
                        if (other$exception == null) {
                            break label102;
                        }
                    } else if (this$exception.equals(other$exception)) {
                        break label102;
                    }

                    return false;
                }

                Object this$startTime = this.getStartTime();
                Object other$startTime = other.getStartTime();
                if (this$startTime == null) {
                    if (other$startTime != null) {
                        return false;
                    }
                } else if (!this$startTime.equals(other$startTime)) {
                    return false;
                }

                Object this$endTime = this.getEndTime();
                Object other$endTime = other.getEndTime();
                if (this$endTime == null) {
                    if (other$endTime != null) {
                        return false;
                    }
                } else if (!this$endTime.equals(other$endTime)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RequestInfo;
    }

    @Override
    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        Object $timeCost = this.getTimeCost();
        result = result * 59 + ($timeCost == null ? 43 : $timeCost.hashCode());
        Object $bid = this.getBid();
        result = result * 59 + ($bid == null ? 43 : $bid.hashCode());
        Object $httpMethod = this.getHttpMethod();
        result = result * 59 + ($httpMethod == null ? 43 : $httpMethod.hashCode());
        Object $url = this.getUrl();
        result = result * 59 + ($url == null ? 43 : $url.hashCode());
        Object $requestParams = this.getRequestParams();
        result = result * 59 + ($requestParams == null ? 43 : $requestParams.hashCode());
        Object $requestHeaders = this.getRequestHeaders();
        result = result * 59 + ($requestHeaders == null ? 43 : $requestHeaders.hashCode());
        Object $classMethod = this.getClassMethod();
        result = result * 59 + ($classMethod == null ? 43 : $classMethod.hashCode());
        Object $ip = this.getIp();
        result = result * 59 + ($ip == null ? 43 : $ip.hashCode());
        Object $actionGroup = this.getActionGroup();
        result = result * 59 + ($actionGroup == null ? 43 : $actionGroup.hashCode());
        Object $action = this.getAction();
        result = result * 59 + ($action == null ? 43 : $action.hashCode());
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        Object $exception = this.getException();
        result = result * 59 + ($exception == null ? 43 : $exception.hashCode());
        Object $startTime = this.getStartTime();
        result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
        Object $endTime = this.getEndTime();
        result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RequestInfo(bid=" + this.getBid() + ", httpMethod=" + this.getHttpMethod() + ", url=" + this.getUrl() + ", requestParams=" + this.getRequestParams() + ", requestHeaders=" + this.getRequestHeaders() + ", classMethod=" + this.getClassMethod() + ", ip=" + this.getIp() + ", timeCost=" + this.getTimeCost() + ", actionGroup=" + this.getActionGroup() + ", action=" + this.getAction() + ", result=" + this.getResult() + ", exception=" + this.getException() + ", startTime=" + this.getStartTime() + ", endTime=" + this.getEndTime() + ")";
    }
}
