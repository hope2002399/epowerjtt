-- 需要填写流程代码
delete from wf_action_log l where l.nodeinstid in 
	(
		select i.nodeinstid from  wf_node_instance i where  i.wfinstid in
		(
			select wfinstid from wf_flow_instance f where f.wfcode = ''
		)
	);
--删除办件角色
delete from wf_team t where t.wfinstid in  (select wfinstid from wf_flow_instance f where f.wfcode = '');

--删除流程实例管理日志
delete from  wf_manage_action t where t.wfinstid in  (select wfinstid from wf_flow_instance f where f.wfcode = '');

--删除节点实例信息
delete from wf_node_instance t where t.wfinstid in (select wfinstid from wf_flow_instance f where f.wfcode = '');

--删除流程实例信息
delete from wf_flow_instance t where t.wfcode = '';
commit;

--清理许可办件信息
delete from opt_base_info o where o.dj_id in (select t.dj_id from sr_permit_apply t);
delete from OPT_IDEA_INFO o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from OPT_PROC_ATTENTION o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from OPT_PROC_INFO o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from OPT_STUFF_INFO o where o.dj_id in(select t.dj_id from sr_permit_apply t);

--行政许可业务表清理
delete from SR_ITEM_BRIDGE o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from SR_ITEM_CABLE o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from SR_ITEM_DOCK o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from SR_ITEM_DRAIN o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from SR_ITEM_RIVERSIGN o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from SR_ITEM_SPAN o where o.dj_id in(select t.dj_id from sr_permit_apply t);
delete from SR_ITEM_TUBE o where o.dj_id in(select t.dj_id from sr_permit_apply t);

--许可表清理
delete from SR_PERMIT_APPLY;
commit;

--某流程下所有办件select t.dj_id from opt_base_info t where t.flowinstid in (select wfinstid from wf_flow_instance f where f.wfcode = '')