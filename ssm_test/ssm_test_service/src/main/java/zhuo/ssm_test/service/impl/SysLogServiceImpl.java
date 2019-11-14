package zhuo.ssm_test.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhuo.ssm_test.dao.ISysLogDao;
import zhuo.ssm_test.domain.SysLog;
import zhuo.ssm_test.service.ISysLogService;

import java.util.List;
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService{
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }
    @Override
    public List<SysLog> findAll(int page, int size) throws Exception {
        //使用分页插件，需在查询方法前
        PageHelper.startPage(page,size);
        List<SysLog> list = sysLogDao.findAll();
        return list;
    }
}
