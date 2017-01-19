package com.mine.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 处理服务channel
 * @author Patrick
 *
 */
public class DiscardServerHandle extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		// 默默丢弃收到的数据
		((ByteBuf) msg).release();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		// 当出现异常就关闭连接
		cause.printStackTrace();
		ctx.close();
	}

}
