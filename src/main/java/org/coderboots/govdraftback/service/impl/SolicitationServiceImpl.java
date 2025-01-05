package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.Solicitation;
import org.coderboots.govdraftback.mapper.SolicitationMapper;
import org.coderboots.govdraftback.service.SolicitationService;
import org.springframework.stereotype.Service;

@Service
public class SolicitationServiceImpl extends ServiceImpl<SolicitationMapper, Solicitation> implements SolicitationService {
}
