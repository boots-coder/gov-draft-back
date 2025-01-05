package org.coderboots.govdraftback.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.coderboots.govdraftback.entity.ReviewComment;
import org.coderboots.govdraftback.mapper.ReviewCommentMapper;
import org.coderboots.govdraftback.service.ReviewCommentService;
import org.springframework.stereotype.Service;

@Service
public class ReviewCommentServiceImpl extends ServiceImpl<ReviewCommentMapper, ReviewComment> implements ReviewCommentService {
}
