package cn.iocoder.yudao.module.system.service.jzldryjl;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldryjl.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldryjl.JzldryjlDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldryjl.JzldryjlMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 教育经历数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldryjlServiceImpl implements JzldryjlService {

    @Resource
    private JzldryjlMapper jzldryjlMapper;

    @Override
    public String createJzldryjl(JzldryjlSaveReqVO createReqVO) {
        // 插入
        JzldryjlDO jzldryjl = BeanUtils.toBean(createReqVO, JzldryjlDO.class);
        jzldryjlMapper.insert(jzldryjl);
        // 返回
        return jzldryjl.getId();
    }

    @Override
    public void updateJzldryjl(JzldryjlSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldryjlExists(updateReqVO.getId());
        // 更新
        JzldryjlDO updateObj = BeanUtils.toBean(updateReqVO, JzldryjlDO.class);
        jzldryjlMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldryjl(String id) {
        // 校验存在
        validateJzldryjlExists(id);
        // 删除
        jzldryjlMapper.deleteById(id);
    }

    private void validateJzldryjlExists(String id) {
        if (jzldryjlMapper.selectById(id) == null) {
            throw exception(JZLDRYJL_NOT_EXISTS);
        }
    }

    @Override
    public JzldryjlDO getJzldryjl(String id) {
        return jzldryjlMapper.selectById(id);
    }

    @Override
    public PageResult<JzldryjlDO> getJzldryjlPage(JzldryjlPageReqVO pageReqVO) {
        return jzldryjlMapper.selectPage(pageReqVO);
    }

}