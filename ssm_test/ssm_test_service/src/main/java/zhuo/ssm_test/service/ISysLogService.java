package zhuo.ssm_test.service;

import zhuo.ssm_test.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    public void save(SysLog log) throws Exception;

    public List<SysLog> findAll(int page, int size) throws Exception;
}
