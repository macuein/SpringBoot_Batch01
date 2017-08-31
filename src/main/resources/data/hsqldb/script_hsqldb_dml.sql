insert into users (firstname, lastname, email) values ('aaaa','bbbb','aaaa@aaaabbbb.com');
insert into users (firstname, lastname, email) values ('cccc','dddd','cccc@ccccdddd.com');
insert into users (firstname, lastname, email) values ('eeee','ffff','eeee@eeeeffff.com');

insert into batchjobs (jobname, jobclass, jobcron) values ('Job A','org.springboot.batch01.jobs.JobTwo','0/20 * * * * ?');
--insert into batchjobs (jobname, jobclass, jobcron) values ('Job B','org.springboot.batch01.jobs.JobTwo','0/25 * * * * ?');
--insert into batchjobs (jobname, jobclass, jobcron) values ('Job C','org.springboot.batch01.jobs.JobTwo','0/30 * * * * ?');
