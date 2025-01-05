package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.Journal;
import org.coderboots.govdraftback.mapper.JournalMapper;
import org.coderboots.govdraftback.service.JournalService;
import org.springframework.stereotype.Service;

@Service
public class JournalServiceImpl extends ServiceImpl<JournalMapper, Journal> implements JournalService {
}
