# NotePadProcessManager
This project exposes 3 end points :
1.http://localhost:8010/notepad/<USERID>/start
  -This will start a notepad process for the given <USERID>
  -if there is already a notepad, this will throw an error
2.http://localhost:8010/notepad/<USERID>/stop
  -This will stop the notepad process if available for the given <USERID>
  -If there are not processes available it will throw error
3.http://localhost:8010/notepad/killOrphanThreads
  -If the process is killed externally this end point would clean up the java storage by deleting such orphan processes
  
  Along with these, a thread is run infinitely that keeps checking each process has elapsed time more than given time (for sample i have used 15000 ms)
  if the process has been opened for more than the time given, it will close the process
