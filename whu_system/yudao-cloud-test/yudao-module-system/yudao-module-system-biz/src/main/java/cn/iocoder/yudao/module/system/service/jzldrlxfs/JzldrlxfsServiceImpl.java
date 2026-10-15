package cn.iocoder.yudao.module.system.service.jzldrlxfs;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.system.controller.admin.jzldrlxfs.vo.*;
import cn.iocoder.yudao.module.system.dal.dataobject.jzldrlxfs.JzldrlxfsDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.system.dal.mysql.jzldrlxfs.JzldrlxfsMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.*;
import com.baomidou.dynamic.datasource.annotation.DS;

import javax.annotation.Resource;

@DS("whu_data")
/**
 * 联系方式数据 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class JzldrlxfsServiceImpl implements JzldrlxfsService {

    @Resource
    private JzldrlxfsMapper jzldrlxfsMapper;

    @Override
    public String createJzldrlxfs(JzldrlxfsSaveReqVO createReqVO) {
        // 插入
        JzldrlxfsDO jzldrlxfs = BeanUtils.toBean(createReqVO, JzldrlxfsDO.class);
        jzldrlxfsMapper.insert(jzldrlxfs);
        // 返回
        return jzldrlxfs.getId();
    }

    @Override
    public void updateJzldrlxfs(JzldrlxfsSaveReqVO updateReqVO) {
        // 校验存在
        validateJzldrlxfsExists(updateReqVO.getId());
        // 更新
        JzldrlxfsDO updateObj = BeanUtils.toBean(updateReqVO, JzldrlxfsDO.class);
        jzldrlxfsMapper.updateById(updateObj);
    }

    @Override
    public void deleteJzldrlxfs(String id) {
        // 校验存在
        validateJzldrlxfsExists(id);
        // 删除
        jzldrlxfsMapper.deleteById(id);
    }

    private void validateJzldrlxfsExists(String id) {
        if (jzldrlxfsMapper.selectById(id) == null) {
            throw exception(JZLDRLXFS_NOT_EXISTS);
        }
    }

    @Override
    public JzldrlxfsDO getJzldrlxfs(String id) {
        return jzldrlxfsMapper.selectById(id);
    }

    @Override
    public PageResult<JzldrlxfsDO> getJzldrlxfsPage(JzldrlxfsPageReqVO pageReqVO) {
        return jzldrlxfsMapper.selectPage(pageReqVO);
    }

}