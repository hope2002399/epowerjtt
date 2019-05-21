delete from APPENTERPRISE;
delete from APPINDIVIDUAL;
delete from B_DATAENTERPRISE;
delete from B_DATAINDIVIDUAL;
delete from B_FREEUMPIREDEGREE;
delete from B_FREEUMPIRETYPE;

delete from b_power;
delete from b_powerchglog;
delete from b_powerchgprocess;
delete from b_powerstatechglog;
delete from b_punishitem;
delete from b_punishstandard;

delete from c_power_org_info;
delete from c_power_opt_info;

delete from M_APPLY;
delete from m_Applydoc;
delete from m_applylog;
delete from m_applyprocess;
delete from m_applyresult;
delete from m_applyresultlog;

delete from m_complaint;
delete from m_complaintsprocess;
delete from m_complaintsresult;

delete from m_dispatch_doc;
delete from m_doc_relative;
delete from m_income_doc;
delete from m_innermsg;

delete from m_outway;
delete from m_outwaycalc;

--
delete from m_paperformanceresult;

delete from m_punish;
delete from m_punishdoc;
delete from m_punishlog;
delete from m_punishprocess;
delete from m_punishresult;
delete from m_punishresultlog;

delete from m_supervisebasic;
delete from m_superviselog;
delete from m_supervisereply;
delete from m_superviseresult;
delete from m_supervisorypersonnel;

delete from m_tempcheckupdetail;

delete from m_tracklog;

delete from opt_apply_info;
delete from opt_base_info;
delete from opt_idea_info;
delete from opt_newly_idea;
delete from opt_proc_attention;
delete from opt_proc_info;
delete from opt_risk_info;
delete from opt_stuff_info;
delete from opt_writdef;
delete from opt_zwh;

delete from p_acceptinfo;
delete from p_approve_basic;
delete from p_decisioninfo;
delete from p_detain_goods_basicinfo;
delete from p_detain_goods_transinfo;

delete from p_discuss_basic;
delete from p_enterprise;
delete from p_excuce_basic;

--


delete from supinfobasic;
delete from supinfobasicdlfx;
delete from sup_jcry_supervisorypersonnel;

--.....

delete from wf_action_log;
delete from wf_action_task;
delete from wf_flow_instance;
delete from wf_manage_action;
delete from wf_node_instance;
delete from wf_organize;
delete from wf_stage_instance;
delete from wf_team;

delete from f_userinfo t where t.usercode not in ('0', 'noname', '99999999');
delete from f_unitinfo t where t.unitcode <>  '1';
delete from f_usersetting t where t.usercode not in ('0', 'default', '99999999',  'noname');
delete from f_userunit t where t.usercode not in ('0', 'noname', '99999999') or t.unitcode <> '1';
delete from f_roleinfo t where t.rolecode not in ('G-sy', 'G-SYSADMIN', 'G-anonymous'); 
delete from f_rolepower t where t.rolecode not in ('G-sy', 'G-SYSADMIN', 'G-anonymous');
delete from f_userrole t where t.usercode not in ('0', 'noname', '99999999') or t.rolecode not in ('G-sy', 'G-SYSADMIN', 'G-anonymous');

delete from JCRY_SUPERVISORYPERSONNEL;
delete from IOBASIC;