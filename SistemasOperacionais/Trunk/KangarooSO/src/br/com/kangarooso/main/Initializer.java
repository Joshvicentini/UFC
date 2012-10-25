package br.com.kangarooso.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import br.com.kangarooso.so.model.KSInterpreter;
import br.com.kangarooso.so.model.Kernel;
import br.com.kangarooso.so.model.KernelInterface;
import br.com.kangarooso.so.model.Shell;
import br.com.kangarooso.so.model.SystemcallInterface;
import br.com.kangarooso.vm.model.Disk;
import br.com.kangarooso.vm.model.Memory;
import br.com.kangarooso.vm.model.Processor;
import br.com.kangarooso.vm.model.VirtualMachine;

public class Initializer {
	public static void main(String[] args) {
		//ABRINDO ARQUIVO DE PROPRIEDADES COM VALORES DEFAULT
		Properties defaultProperties = new Properties();
		try{
			defaultProperties.load(new FileInputStream("properties/defaults.properties"));
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
		//LENDO VALORES DEFAULT
		Long memorySize = Long.valueOf((String)defaultProperties.get("MEMORY_SIZE"));
		Long diskSize = Long.valueOf((String)defaultProperties.get("DISK_SIZE"));
		
		//CRIANDO MAQUINA VIRTUAL
		VirtualMachine vm = new VirtualMachine(new Disk(diskSize), new Memory(memorySize), new Processor());
		//CRIANDO A INTERFACE COM O KERNEL
		KernelInterface kernelInterface = new KernelInterface(vm);
		//CRIANDO O KERNEL
		Kernel kernel = new Kernel(kernelInterface);
		//CRIANDO A INTERFACE COM AS SYSTEMCALLS
		SystemcallInterface systemcallInterface = new SystemcallInterface(kernel);
		//CRIANDO O INTERPRETADOR DE SCRIPT
		KSInterpreter ksInterpreter = new KSInterpreter(kernel);
		//CRIANDO O SHELL
		Shell shell = new Shell(systemcallInterface, ksInterpreter);
		//INICIALIZANDO O SHELL
		shell.init();
	}
}
