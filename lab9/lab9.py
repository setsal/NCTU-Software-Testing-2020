import angr
from angrutils import *
import claripy

p = angr.Project("/home/setsal/nctu/st/Lab/lab9/guest", auto_load_libs=False)



# Gen control flow graph
# main = p.loader.main_object.get_symbol("main")
# start_state = p.factory.blank_state(addr=main.rebased_addr)
# cfg = p.analyses.CFGEmulated(fail_fast=True, starts=[main.rebased_addr], initial_state=start_state)
# plot_cfg(cfg, "lab9_cfg", asminst=True, remove_imports=True, remove_path_terminator=True)  


args = claripy.BVS("args",100*8)
initial_state = p.factory.entry_state(args=["/home/setsal/nctu/st/Lab/lab9/guest", args])
simgr = p.factory.simulation_manager(initial_state)
simgr.explore(find=0x4005d1)


found = simgr.found[0]
print(found)
print(found.solver.eval(args, cast_to=bytes))