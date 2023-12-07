package exchance.grupo.apiexchance.service.hostFamily.dto;


import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyTokenDto;

public class HostFamilyMapper {

  public static HostFamily of(HostFamilyDTO hostFamilyDTO) {
   HostFamily hostFamily = new HostFamily();

   hostFamily.setDescricao(hostFamilyDTO.getDescricao());
   hostFamily.setEmail(hostFamilyDTO.getEmail());
   hostFamily.setNome(hostFamilyDTO.getNome());
   hostFamily.setSenha(hostFamilyDTO.getSenha());
   hostFamily.setLocalidade(hostFamilyDTO.getLocalidade());
   hostFamily.setVerificado(hostFamilyDTO.getVerificado());
   hostFamily.setTelefone(hostFamilyDTO.getTelefone());

    return hostFamily;
  }

 public static HostFamilyTokenDto of(HostFamily hostFamily, String token) {
    HostFamilyTokenDto hostFamilyTokenDto = new HostFamilyTokenDto();

     hostFamilyTokenDto.setIdHostFamily(hostFamily.getIdHostFamily());
     hostFamilyTokenDto.setEmail(hostFamily.getEmail());
     hostFamilyTokenDto.setNome(hostFamily.getNome());
     hostFamilyTokenDto.setToken(token);

    return hostFamilyTokenDto;
  }
}
