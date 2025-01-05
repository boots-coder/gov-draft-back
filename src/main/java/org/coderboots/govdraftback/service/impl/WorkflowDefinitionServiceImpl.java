package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.WorkflowDefinition;
import org.coderboots.govdraftback.mapper.WorkflowDefinitionMapper;
import org.coderboots.govdraftback.service.WorkflowDefinitionService;
import org.springframework.stereotype.Service;

@Service
public class WorkflowDefinitionServiceImpl extends ServiceImpl<WorkflowDefinitionMapper, WorkflowDefinition> implements WorkflowDefinitionService {
}
